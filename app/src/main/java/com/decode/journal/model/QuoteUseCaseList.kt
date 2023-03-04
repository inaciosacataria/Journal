package com.decode.journal.model

import com.decode.journal.R

data class Quote(
    var resDrawable: Int,
    var resCategory: String
)

object QuoteUseCase{
    var quote = Quote(R.drawable.meditation, "Daily Quote")
}

object QuoteUseCaseList {
    var quote: List<Quote> = listOf<Quote>(
        Quote(R.drawable.meditation, "Daily\nQuote"),
        Quote(R.drawable.meditation, "Morning\nMeditation"),
        Quote(R.drawable.meditation, "Evening\nMedidation"),
        Quote(R.drawable.meditation, "Reconect"),
        Quote(R.drawable.meditation, "4 Habits"),
        Quote(R.drawable.meditation, "Goals"),
        Quote(R.drawable.meditation, "Medidation")
    )
}
