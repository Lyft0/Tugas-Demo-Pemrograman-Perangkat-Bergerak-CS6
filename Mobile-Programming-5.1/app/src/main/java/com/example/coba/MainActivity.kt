package com.example.coba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    // Variabel anggota untuk menyimpan skor
    private var mScore1: Int = 0
    private var mScore2: Int = 0

    // Variabel anggota untuk dua elemen TextView skor
    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView

    // Tag yang akan digunakan sebagai kunci dalam OnSavedInstanceState
    companion object {
        const val STATE_SCORE_1 = "Skor Tim 1"
        const val STATE_SCORE_2 = "Skor Tim 2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Temukan TextViews berdasarkan ID
        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)

        // Mengembalikan skor jika ada savedInstanceState.
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            // Tetapkan TextView skor
            mScoreText1.text = mScore1.toString()
            mScoreText2.text = mScore2.toString()
        }
    }

    fun decreaseScore(view: View) {
        // Dapatkan ID tombol yang diklik.
        val viewID = view.id
        when (viewID) {
            // Jika itu adalah Tim 1:
            R.id.decreaseTeam1 -> {
                // Kurangi skor dan perbarui TextView.
                if(mScore1 != 0 ) mScore1--
                mScoreText1.text = mScore1.toString()
            }
            // Jika itu adalah Tim 2:
            R.id.decreaseTeam2 -> {
                // Kurangi skor dan perbarui TextView.
                if(mScore2 != 0 ) mScore2--
                mScoreText2.text = mScore2.toString()
            }
        }
    }

    fun increaseScore(view: View) {
        // Dapatkan ID tombol yang diklik.
        val viewID = view.id
        when (viewID) {
            // Jika itu adalah Tim 1:
            R.id.increaseTeam1 -> {
                // Tambahkan skor dan perbarui TextView.
                mScore1++
                mScoreText1.text = mScore1.toString()
            }
            // Jika itu adalah Tim 2:
            R.id.increaseTeam2 -> {
                // Tambahkan skor dan perbarui TextView.
                mScore2++
                mScoreText2.text = mScore2.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        // Ubah label menu berdasarkan status aplikasi.
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Periksa apakah item yang benar telah diklik.
        if (item.itemId == R.id.night_mode) {
            // Dapatkan mode malam aplikasi.
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            // Atur mode tema untuk aktivitas yang di-recreate.
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            // Membuat ulang aktivitas agar perubahan tema berlaku.
            recreate()
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Simpan skor.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }
}