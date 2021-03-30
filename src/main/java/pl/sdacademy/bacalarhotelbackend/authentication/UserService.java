package pl.sdacademy.bacalarhotelbackend.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sdacademy.bacalarhotelbackend.guest.GuestRepository;

@Service
public class UserService implements UserDetailsService {
    private GuestRepository guestRepository;

    public UserService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return guestRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No such user"));
    }
}
