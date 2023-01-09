package io.github.tuguzd.gamegenbulb.domain.repository.util

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.DeleteRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.SaveRepository

public interface CrudRepository<T : Node> :
    SaveRepository<T>, ReadRepository<T>, DeleteRepository<T>
