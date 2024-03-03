package banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banking.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
    
}
