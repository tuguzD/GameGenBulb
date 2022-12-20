package io.github.tuguzd.gamegenbulb.domain.repository.util

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.*

public interface CrudRepository<T : Node> :
    CreateRepository<T>, ReadRepository<T>,
    UpdateRepository<T>, DeleteRepository<T>
