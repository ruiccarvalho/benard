package model.cinemateca

import org.joda.time.LocalDate

case class Day(
  date: LocalDate,
  screenings: List[Movie]
)
