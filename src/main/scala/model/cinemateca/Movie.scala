package model.cinemateca

case class Movie(
  primaryTitle: String,
  secondaryTitle: Option[String],
  dateLine: Option[String],
  fromLine: Option[String],
  starringLine: Option[String],
  about: Option[String]
)
