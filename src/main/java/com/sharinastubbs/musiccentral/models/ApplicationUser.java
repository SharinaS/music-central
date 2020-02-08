package com.sharinastubbs.musiccentral.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;
    String firstname;

    //== DB Setup ==
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    List<Artist> artists;

    //== Constructors ==
    public ApplicationUser() {}

    public ApplicationUser(String username, String password, String firstname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
    }

    //== Abstract methods implemented in UserDetails ==
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    // Other Getters
    public String getFirstname() {
        return firstname;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}
