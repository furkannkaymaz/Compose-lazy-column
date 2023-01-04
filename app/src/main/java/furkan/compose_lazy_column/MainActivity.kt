package furkan.compose_lazy_column

import android.os.Bundle
import android.widget.HeterogeneousExpandableList
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import furkan.compose_lazy_column.ui.theme.ComposelazycolumnTheme
import furkan.compose_lazy_column.ui.theme.PURPLE

//TODO all Text' should  collect under a function

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposelazycolumnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversation(DummyData.data)
                }
            }
        }
    }
}

@Composable
fun UserCardMan(user: User) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                Toast
                    .makeText(
                        context,
                        "${user.name} - ${user.surname} -${user.job}", Toast.LENGTH_SHORT
                    )
                    .show()
            }
            .background(color = Color.Gray, shape = RoundedCornerShape(20.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(user.image),
            contentDescription = "man",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
            //.border(2.dp, Color.White, CircleShape)
        )
        Column() {
            Text(
                text = user.name,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
            Text(
                text = user.surname,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
        }
        Column() {
            Text(
                text = user.job,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
            Text(
                text = user.experience,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "${user.name} - ${user.surname} -${user.job}", Toast.LENGTH_SHORT
                            )
                            .show()
                    }
            )
        }

    }
}

@Composable
fun UserCardFemale(user: User) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(PURPLE)
            .clickable {
                Toast
                    .makeText(
                        context,
                        "${user.name} - ${user.surname} -${user.job}", Toast.LENGTH_SHORT
                    )
                    .show()
            }
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(0.dp)),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(user.image),
            contentDescription = "female",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)

            //.border(2.dp, Color.White, CircleShape)
        )
        Column() {
            Text(
                text = user.name,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
            Text(
                text = user.surname,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
        }
        Column() {
            Text(
                text = user.job,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
            Text(
                text = user.experience,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(all = 15.dp)
            )
        }

    }
}

@Composable
fun Conversation(user: List<User>) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(all = 15.dp),
            text = "USERS",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            style = MaterialTheme.typography.body1,

        )
        LazyColumn {
            items(user) { user ->
                if (user.gender == Gender.MALE) {
                    UserCardMan(user)
                } else {
                    UserCardFemale(user)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposelazycolumnTheme {
        Conversation(DummyData.data)
    }
}