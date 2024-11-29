package whz.pti.eva.common;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<PK extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        BaseEntity<?> other = (BaseEntity<?>) a;
        return this.getId() != null && this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
    	if (getId() != null) {
			return getId().hashCode();
		}
		return super.hashCode();
    }
}
