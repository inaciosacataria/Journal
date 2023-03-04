import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.decode.journal.R
import com.decode.journal.model.*


@Composable
fun MyTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        //  .background(colorResource(id = R.color.brownwhite)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_event_24),
            "",
            modifier = Modifier.padding(start = 16.dp, top = 32.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            "",
            modifier = Modifier.padding(end = 16.dp, top = 32.dp)
        )
    }
}


@Composable
fun header(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "SUNDAY, NOVEMBER 6",
            modifier.padding(top = 32.dp),
            color = colorResource(id = R.color.datedaycolor)
        )
        Text(
            text = "Good morning, Inácio!",
            modifier = modifier.padding(top = 16.dp),
            color = colorResource(id = R.color.brownblack),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
        )
        Button(
            onClick = { onClick },
            modifier = modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.yellow), contentColor = colorResource(
                    id = R.color.brownblack
                )
            ),
            shape = RoundedCornerShape(18),

            ) {
            Text(text = "Start Today's Journal")
        }
    }
}


@Composable
fun circleImages(quote: Quote = QuoteUseCase.quote) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp, color = colorResource(
                        id = R.color.yellow
                    ),
                    CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = quote.resDrawable),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(66.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp, color = colorResource(
                            id = R.color.white
                        ),
                        CircleShape
                    ),
            )
        }
        Text(
            text = quote.resCategory,
            modifier = Modifier.padding(top = 4.dp),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.brownblack),
            fontSize = 12.sp
        )
    }
}

@Composable
fun rowImages(quoteList: List<Quote> = QuoteUseCaseList.quote) {
    LazyRow {
        items(items = quoteList) { quote ->
            Spacer(modifier = Modifier.width(8.dp))
            circleImages(quote)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun dateshow(date: Date = Date("", 24, "TUE"), heightLine: Int = 32) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(colorResource(id = R.color.brownclaro))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = date.dayOfWeek,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.datedaycolor)
                )
                Text(
                    text = date.day.toString(),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.brown)
                )
            }
        }

        Spacer(
            modifier = Modifier
                .width(2.dp)
                .height(heightLine.dp)
                .padding(top = 2.dp)
                .background(colorResource(id = R.color.brownclaro))
        )
    }
}

@Preview
@Composable
fun noteContent(
    title: String = "Note",
    description: String = "Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum"
) {
    Column {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.datedaycolor)
        )
        Text(
            text = description,
            textAlign = TextAlign.Start,
            color = colorResource(id = R.color.brown)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NotesContent(
    note: Notes = NotesData.notes
) {
    Column() {
        Text(
            text = note.month + " " + note.year,
            textAlign = TextAlign.Start,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
            color = colorResource(id = R.color.brown)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            items(items = note.noteList) { noteItem ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    dateshow(noteItem.date, 100)
                    Spacer(modifier = Modifier.width(16.dp))
                    noteContent(noteItem.title, noteItem.description)
                }

                if (!noteItem.images.isNullOrEmpty()) {
                    Image(
                        painter = painterResource(id = R.drawable.meditation),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .clip(RoundedCornerShape(4)),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

    }
}


@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = colorResource(id = R.color.brownwhite)
    ) {
        Column {
            header(Modifier, {})
            Spacer(modifier = modifier.height(32.dp))
            rowImages()
            Spacer(modifier = modifier.height(32.dp))
            NotesContent()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = colorResource(id = R.color.brownwhite),
        contentColor = colorResource(id = R.color.brown),
        topBar = { MyTopBar() }
    ) {

        HomeContent()
    }
}