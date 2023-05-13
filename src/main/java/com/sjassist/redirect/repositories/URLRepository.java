package com.sjassist.redirect.repositories;

import com.sjassist.redirect.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
    List<URL> findByShortString(String shortString);
}
