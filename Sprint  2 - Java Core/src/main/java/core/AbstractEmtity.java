package core;

import java.time.LocalDateTime;

public abstract class AbstractEmtity {
    public Long id;
    public int version;
    public LocalDateTime created;
    public LocalDateTime modifiedAt;

    public AbstractEmtity(Long id, int version, LocalDateTime created, LocalDateTime modifiedAt) {
        this.id = id;
        this.version = version;
        this.created = created;
        this.modifiedAt = modifiedAt;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
