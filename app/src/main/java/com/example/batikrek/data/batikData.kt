package com.example.batikrek.data

import com.example.batikrek.R

data class Batik(
    val name: String,
    val motif: String,
    val suitableFor: String,
    val imageRes: Int
) {
    companion object {
        val batikData = listOf(
            Batik(
                name = "Batik Parang",
                motif = "Motif Parang Rusak",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_parang
            ),
            Batik(
                name = "Batik Mega Mendung",
                motif = "Motif Mega Mendung",
                suitableFor = "Acara Formal, Acara Keluarga",
                imageRes = R.drawable.batik_mega_mendung
            ),
            Batik(
                name = "Batik Kawung",
                motif = "Motif Kawung",
                suitableFor = "Acara Formal, Casual",
                imageRes = R.drawable.batik_kawung
            ),
            Batik(
                name = "Batik Truntum",
                motif = "Motif Truntum",
                suitableFor = "Acara Keluarga, Pernikahan",
                imageRes = R.drawable.batik_truntum
            ),
            Batik(
                name = "Batik Jlamprang",
                motif = "Motif Jlamprang",
                suitableFor = "Pernikahan, Pesta",
                imageRes = R.drawable.batik_jlamprang
            ),
            Batik(
                name = "Batik Ceplok",
                motif = "Motif Ceplok",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_ceplok
            ),
            Batik(
                name = "Batik Sekar Jagad",
                motif = "Motif Seka Jagad",
                suitableFor = "Acara Formal, Acara Keluarga",
                imageRes = R.drawable.batik_sekarjagad
            ),
            Batik(
                name = "Batik Lasem",
                motif = "Motif Lasem",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_lasem
            ),
            Batik(
                name = "Batik Buketan",
                motif = "Motif Buketan",
                suitableFor = "Pernikahan, Pesta",
                imageRes = R.drawable.batik_buketan
            ),
            Batik(
                name = "Batik Pekalongan",
                motif = "Motif Pekalongan",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_pekalongan
            ),
            Batik(
                name = "Batik Sidomukti",
                motif = "Motif Sidomukti",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_sidomukti
            ),
            Batik(
                name = "Batik Cuwiri",
                motif = "Motif Cuwiri",
                suitableFor = "Acara Keluarga, Casual",
                imageRes = R.drawable.batik_cuwiri
            ),
            Batik(
                name = "Batik Bunga",
                motif = "Motif Bunga",
                suitableFor = "Pesta, Casual",
                imageRes = R.drawable.batik_bunga
            ),
            Batik(
                name = "Batik Tujuh Rupa",
                motif = "Motif Tujuh Rupa",
                suitableFor = "Acara Keluarga, Pesta",
                imageRes = R.drawable.batik_tujuhrupa
            ),
            Batik(
                name = "Batik Barong",
                motif = "Motif Barong",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_barong
            ),
            Batik(
                name = "Batik Batu",
                motif = "Motif Batu",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_batu
            ),
            Batik(
                name = "Batik Selendang",
                motif = "Motif Selendang",
                suitableFor = "Casual, Pesta",
                imageRes = R.drawable.batik_selendang
            ),
            Batik(
                name = "Batik Lurik",
                motif = "Motif Lurik",
                suitableFor = "Acara Keluarga, Casual",
                imageRes = R.drawable.batik_lurik
            ),
            Batik(
                name = "Batik Cempaka",
                motif = "Motif Cempaka",
                suitableFor = "Pernikahan, Pesta",
                imageRes = R.drawable.batik_cempaka
            ),
            Batik(
                name = "Batik Tulis",
                motif = "Motif Tulis",
                suitableFor = "Acara Formal, Pernikahan",
                imageRes = R.drawable.batik_tulis
            ),
        )
    }
}