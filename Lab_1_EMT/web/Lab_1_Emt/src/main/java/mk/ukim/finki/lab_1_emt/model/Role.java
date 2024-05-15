package mk.ukim.finki.lab_1_emt.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    LIBRARIAN,
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
