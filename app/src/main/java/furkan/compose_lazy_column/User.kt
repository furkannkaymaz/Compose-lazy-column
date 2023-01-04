package furkan.compose_lazy_column

import androidx.annotation.DrawableRes

data class User(
    val name: String,
    val surname: String,
    val job: String,
    val gender: Gender,
    val experience: String,
    @DrawableRes val image: Int,
)

enum class Gender {
    MALE,
    FEMALE
}
