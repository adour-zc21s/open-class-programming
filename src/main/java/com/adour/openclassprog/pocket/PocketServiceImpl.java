package com.adour.openclassprog.pocket;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
/*
 * @author {Riset Inovasi Ekosistem Komputasi}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 27/09/2026 - 18:29
 */
@Service
@Transactional
public class PocketServiceImpl implements PocketService {

    private final PocketRepository pocketRepository;
    private final PocketItemRepository itemRepository;

    public PocketServiceImpl(PocketRepository pocketRepository, PocketItemRepository itemRepository) {
        this.pocketRepository = pocketRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Pocket createPocket(Pocket pocket) {
        return pocketRepository.save(pocket);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pocket> getAllPockets() {
        return pocketRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pocket getPocketById(Long id) {
        return pocketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pocket tidak ditemukan dengan ID: " + id));
    }

    @Override
    public void deletePocket(Long id) {
        Pocket pocket = getPocketById(id);
        pocketRepository.delete(pocket);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getPocketBalance(Long id) {
        Pocket pocket = getPocketById(id);
        return pocket.getTotalBalance();
    }

    @Override
    public PocketItem addItemToPocket(Long pocketId, PocketItem item) {
        Pocket pocket = getPocketById(pocketId);
        pocket.addItem(item);
        return itemRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PocketItem> getItemsByPocketId(Long pocketId) {
        getPocketById(pocketId); // Memastikan pocket ada
        return itemRepository.findByPocketId(pocketId);
    }

    @Override
    public void deleteItem(Long itemId) {
        if (!itemRepository.existsById(itemId)) {
            throw new RuntimeException("Item tidak ditemukan dengan ID: " + itemId);
        }
        itemRepository.deleteById(itemId);
    }
    @Override
    @Transactional(readOnly = true)
    public MonthlyReportResponseDTO getMonthlyReport(Long pocketId, int month, int year) {
        Pocket pocket = getPocketById(pocketId); // Validasi pocket ada
        List<PocketItem> items = itemRepository.findByPocketIdAndMonthAndYear(pocketId, month, year);

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpense = BigDecimal.ZERO;

        for (PocketItem item : items) {
            if (item.getType() == TransactionType.GAJI || item.getType() == TransactionType.PEMASUKAN_LAIN) {
                totalIncome = totalIncome.add(item.getAmount());
            } else if (item.getType() == TransactionType.PENGELUARAN) {
                totalExpense = totalExpense.add(item.getAmount());
            }
        }

        BigDecimal monthlyBalance = totalIncome.subtract(totalExpense);

        return new MonthlyReportResponseDTO(
                pocket.getId(),
                pocket.getName(),
                month,
                year,
                totalIncome,
                totalExpense,
                monthlyBalance,
                items
        );
    }
}
