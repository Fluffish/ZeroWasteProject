package Hibernate.Tables;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "storage_type")
public class Storage_Type {
    private Integer id_storage;
    private String storage_name;
    private Float storage_temp;

    public Storage_Type() {
    }

    public Storage_Type(Integer id_storage, String storage_name, Float storage_temp) {
        this.id_storage = id_storage;
        this.storage_name = storage_name;
        this.storage_temp = storage_temp;
    }

    public Storage_Type(String storage_name, Float storage_temp) {
        this.storage_name = storage_name;
        this.storage_temp = storage_temp;
    }

    @Id
    @Column(name = "id_storage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_storage() {
        return id_storage;
    }

    public void setId_storage(Integer id_storage) {
        this.id_storage = id_storage;
    }

    @Column(name = "storage_name")
    @NotNull
    public String getStorage_name() {
        return storage_name;
    }

    public void setStorage_name(String storage_name) {
        this.storage_name = storage_name;
    }

    @Column(name = "storage_temp")
    @NotNull
    public Float getStorage_temp() {
        return storage_temp;
    }

    public void setStorage_temp(Float storage_temp) {
        this.storage_temp = storage_temp;
    }
}
