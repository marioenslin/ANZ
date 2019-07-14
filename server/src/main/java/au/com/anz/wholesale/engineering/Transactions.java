package au.com.anz.wholesale.engineering;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Transactions {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String AccountNumber;
    private @NonNull String AccountName;
    private @NonNull String ValueDate;
    private @NonNull String Currency;
    private Double DtAmount;
    private Double CtAmount;
    private @NonNull String DtCt;
    private String TransactionNarative;
    
}