package com.example.tugasmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class UbahProfile : AppCompatActivity(), View.OnClickListener {
    private lateinit var etNama: EditText
    private lateinit var etNim: EditText
    private lateinit var etJurusan: EditText
    private lateinit var btnUbah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_profile)
        relationToXml()
    }

    private fun relationToXml(){
        etNama = findViewById(R.id.et_nama)
        etNim = findViewById(R.id.et_nim)
        etJurusan = findViewById(R.id.et_jurusan)
        btnUbah = findViewById(R.id.btn_ubah_data)
        btnUbah.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val itn = Intent(this@UbahProfile, MainActivity::class.java)
        itn.putExtra(MainActivity.EXTRA_NAMA, etNama.text.toString())
        itn.putExtra(MainActivity.EXTRA_NIM, etNim.text.toString())
        itn.putExtra(MainActivity.EXTRA_JURUSAN, etJurusan.text.toString())
        startActivity(itn)
    }
}