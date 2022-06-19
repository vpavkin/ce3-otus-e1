package otus

import cats.effect.IOApp
import cats.effect.IO

object FilesAndHttpIO extends IOApp.Simple {

  def readFile(path: Path): IO[String] =
    IO.pure(s"this is file with all the passwords at $path")

  def httpPost(url: URI, body: String): IO[Unit] =
    IO.delay(println(s"POST '$url': $body"))

  def run: IO[Unit] =
    for {
      _ <- IO.delay(println("Enter file path:"))
      path <- IO.readLine
      data <- readFile(path)
      _ <- httpPost("https://gosuslugi.ru", data)
    } yield ()

}
