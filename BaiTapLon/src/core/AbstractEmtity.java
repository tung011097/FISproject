package core;

import java.time.LocalDateTime;

public abstract class AbstractEmtity {
    public Long id;
    public int version;
    public LocalDateTime createdA;
    public LocalDateTime modifiedAt;

    public AbstractEmtity(Long id, int version, LocalDateTime createdA, LocalDateTime modifiedAt) {
        this.id = id;
        this.createdA = createdA;
        this.modifiedAt = modifiedAt  ;
    }

    public AbstractEmtity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreatedA() {
        return createdA;
    }

    public void setCreatedA(LocalDateTime createdA) {
        this.createdA = createdA;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
