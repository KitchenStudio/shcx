package org.kitchenstudio.repository;

import org.kitchenstudio.entity.ContactItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactItemRepository extends JpaRepository<ContactItem, Long> {

}
