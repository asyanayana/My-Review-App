package org.d3if1016.asessment2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if1016.asessment2.databinding.ActivitySettingBinding

class SettingActivity: AppCompatActivity() {

    val PREFS_KEY = "rahasia45"
    val PREFS_NAME = "Name"
    val PREFS_KETERANGAN = "Keterangan"
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Setting"

        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

        binding.buttonSimpan.setOnClickListener {
            if (binding.editTextNama.text.toString().isNotEmpty()) {
                saveName(binding.editTextNama.text.toString())
                Toast.makeText(this, "Berhasil merubah Nama", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Isi nama terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        this.startActivity(Intent(this, MainActivity::class.java))
        return true
    }

    private fun saveName(name: String){
        val editor:SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(PREFS_NAME, name)
        editor.apply()
    }
}