package com.example.tugasmobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_JURUSAN = "extra_jurusan"
    }

    private lateinit var btnPesan: Button
    private lateinit var btnIg: Button
    private lateinit var btnPhone: Button
    private lateinit var btnUbah: Button
    private lateinit var btnBottomNav: Button

    private lateinit var tvNama: TextView
    private lateinit var tvNim: TextView
    private lateinit var tvJurusan: TextView

    private lateinit var etPesan: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relationToXml()
        getDataFromIntentUbah()
    }

    private fun getDataFromIntentUbah(){
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val nim = intent.getStringExtra(EXTRA_NIM)
        val jurusan = intent.getStringExtra(EXTRA_JURUSAN)

        tvNama.text = nama
        tvNim.text = nim
        tvJurusan.text = jurusan
    }

    private fun relationToXml(){
        etPesan = findViewById(R.id.et_pesan)

        tvNama = findViewById(R.id.tv_nama_lengkap)
        tvNim = findViewById(R.id.tv_nim)
        tvJurusan = findViewById(R.id.tv_jurusan)

        btnPesan = findViewById(R.id.btn_kirim_pesan)
        btnIg = findViewById(R.id.btn_ig)
        btnPhone = findViewById(R.id.btn_phone)
        btnUbah = findViewById(R.id.btn_ubah)
        btnBottomNav = findViewById(R.id.btn_fragment)

        btnPesan.setOnClickListener(this)
        btnIg.setOnClickListener(this)
        btnPhone.setOnClickListener(this)
        btnUbah.setOnClickListener(this)
        btnBottomNav.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_kirim_pesan -> {
                var inputPesan = "Anda mengirimkan pesan: \n"
                inputPesan += etPesan.text.toString()
                Toast.makeText(applicationContext, inputPesan, Toast.LENGTH_LONG).show()
            }
            R.id.btn_ig -> {
                val urlIg = Uri.parse("http://instagram.com/addthoriq")
                val insta = Intent(Intent.ACTION_VIEW, urlIg)
                insta.setPackage("com.instagram.android")
                try {
                    startActivity(insta)
                } catch (e: Exception){
                    startActivity(Intent(Intent.ACTION_VIEW, urlIg))
                }
            }
            R.id.btn_phone -> {
                val numb = "082232757758"
                val itn = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $numb"))
                startActivity(itn)
            }
            R.id.btn_ubah -> {
                val itn = Intent(this@MainActivity, UbahProfile::class.java)
                startActivity(itn)
            }
            R.id.btn_fragment -> {
                val itn = Intent(this@MainActivity, BottomNavigation::class.java)
                startActivity(itn)
            }
        }
    }
}