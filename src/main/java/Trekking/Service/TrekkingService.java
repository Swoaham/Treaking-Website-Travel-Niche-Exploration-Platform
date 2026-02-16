package Trekking.Service;

import java.util.List;

import Trekking.entities.Trekking;
import Trekking.entities.User;

public interface TrekkingService {

    // ---------- TREKKING ----------
    List<Trekking> getAllTreks();

    Trekking getTrekkingById(Long id);

    void saveTrekking(Trekking trekking);

    void deleteTrekking(Long id);

    List<Trekking> searchTreks(String query);

    // ---------- USERS ----------
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);
}
