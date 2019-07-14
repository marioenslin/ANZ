package au.com.anz.wholesale.engineering;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Accounts {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String AccountNumber;
    private @NonNull String AccountName;
    private @NonNull String AccountType;
    private @NonNull String BalanceDate;
    private @NonNull String Currency;
    private @NonNull Double OpeningBalance;
    
}