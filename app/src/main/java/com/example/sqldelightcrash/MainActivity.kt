package com.example.sqldelightcrash

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sqldelight.User
import com.squareup.sqldelight.android.AndroidSqliteDriver
import java.util.UUID

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val db = TestDb(
      driver = AndroidSqliteDriver(TestDb.Schema, applicationContext, name = "test.db"),
      UserAdapter = User.Adapter(IdColumnAdapter)
    )

    db.transaction {

      (0..3).forEach {
        val id = Id(UUID.randomUUID().toString())
        db.userQueries.insert(id)
      }

    }

    Log.i("TAG", db.userQueries.select().executeAsList().toString())
  }
}
