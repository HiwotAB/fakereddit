package com.reddit.fakereddit.Repositories;

import com.reddit.fakereddit.Model.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link,Long> {
    Iterable<Link> findByUserName(String x);
}
