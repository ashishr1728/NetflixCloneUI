package com.example.netflixcloneui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixcloneui.ui.theme.NetflixCloneUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ){
                TopAppBar()
                NetflixContentChoose()
                FeaturedMovieSection()
                addMoviesList("Watch It Again")
                addMoviesList("Bollywood")
                addMoviesList("Hollywood")
                addMoviesList("Korean Drama")
                addMoviesList("Action Movie")
                addMoviesList("Most Watched")
                addMoviesList("New Release")
            }
        }
    }

    @Composable
    fun TopAppBar(){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.netflixicon),
                modifier = Modifier.size(60.dp),
                contentDescription = "icon")
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(painter = painterResource(id = R.drawable.search),
                    modifier = Modifier
                        .padding(end = 18.dp)
                        .size(30.dp),
                    contentDescription = "search")
                Image(painter = painterResource(id = R.drawable.profile),
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(35.dp),
                    contentDescription = "profile")
            }
        }
    }

    @Composable
    fun NetflixContentChoose(){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "TV Shows", color = Color.LightGray, fontSize = 18.sp)
            Text(text = "Movies", color = Color.LightGray, fontSize = 18.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Categories", color = Color.LightGray, fontSize = 18.sp)
                Image(painter = painterResource(id = R.drawable.ic_drop), contentDescription = "drop menu")
            }
        }
    }


    @Composable
    fun FeaturedMovieSection(){
        Column (
            modifier = Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = R.drawable.thewitcher),
                modifier = Modifier
                    .size(240.dp),
                contentDescription = "The Witcher")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Thriller", color = Color.White, fontSize = 18.sp)
                Image(painter = painterResource(id = R.drawable.ic_dot), modifier = Modifier.size(8.dp), contentDescription = "dot")
                Text(text = "Magical", color = Color.White, fontSize = 18.sp)
                Image(painter = painterResource(id = R.drawable.ic_dot), modifier = Modifier.size(8.dp), contentDescription = "dot")
                Text(text = "Action", color = Color.White, fontSize = 18.sp)
                Image(painter = painterResource(id = R.drawable.ic_dot), modifier = Modifier.size(8.dp), contentDescription = "dot")
                Text(text = "Love", color = Color.White, fontSize = 18.sp)
            }

            Row(
                modifier = Modifier
                    .padding(top = 30.dp, start = 40.dp, end = 40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.baseline_add_24), modifier = Modifier.size(20.dp), contentDescription = "Add")
                    Text(text = "My List", color = Color.LightGray, fontSize = 15.sp)
                }

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play", color = Color.Black, fontSize = 20.sp)
                }

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(id = R.drawable.info), modifier = Modifier.size(20.dp), contentDescription = "Info")
                    Text(text = "Info", color = Color.LightGray, fontSize = 15.sp)
                }
            }
        }
    }

    @Composable
    fun addMoviesList(movieType : String){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
        ){
            Text(text = movieType,
                color = Color.LightGray,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp, start = 12.dp))

            LazyRow(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            ){
                itemsIndexed(getRandomMovieList()){
                        index, item -> MovieItemUIModel(item.image)
                }
            }
        }
    }

    @Composable
    fun MovieItemUIModel(
        imageRes : Int
    ){
        Image(painter = painterResource(id = imageRes),
            contentDescription = "Movies",
            modifier = Modifier
                .height(165.dp)
                .width(120.dp)
            )
    }

    fun getRandomMovieList() : List<MovieItemModel>{
        val listOfMovies = mutableListOf<MovieItemModel>()
        listOfMovies.add(MovieItemModel(R.drawable.movie_1899))
        listOfMovies.add(MovieItemModel(R.drawable.daredevil))
        listOfMovies.add(MovieItemModel(R.drawable.wednesday))
        listOfMovies.add(MovieItemModel(R.drawable.thewitcher))
        listOfMovies.add(MovieItemModel(R.drawable.thegreyman))
        listOfMovies.add(MovieItemModel(R.drawable.thecrown))
        listOfMovies.add(MovieItemModel(R.drawable.strangerthings))
        listOfMovies.add(MovieItemModel(R.drawable.slumberland))
        listOfMovies.add(MovieItemModel(R.drawable.onepiece))
        listOfMovies.add(MovieItemModel(R.drawable.moneyheist))

        listOfMovies.shuffle()

        return listOfMovies
    }
}



data class MovieItemModel(
    val image : Int
)