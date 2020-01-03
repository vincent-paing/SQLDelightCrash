package com.example.sqldelightcrash

import com.squareup.sqldelight.ColumnAdapter

/**
 * Created by Vincent on 1/3/20
 */
object IdColumnAdapter : ColumnAdapter<Id, String> {

  override fun decode(databaseValue: String): Id {
    return Id(databaseValue)
  }

  override fun encode(value: Id): String {
    return value.value
  }

}