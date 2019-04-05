package nl.azure.cosmos.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Account {
    @Id
    private ObjectId id;

    private String accountNumber;
    private String balance;

    public String getId() {
        return this.id.toString();
    }
}
