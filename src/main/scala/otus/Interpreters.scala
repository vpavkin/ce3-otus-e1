package otus

import cats.effect.IO

object Interpreters {
  implicit val consoleIO: Console[IO] = new Console[IO] {
    def readLine: IO[Path] = IO.readLine
    def printLine(line: Path): IO[Unit] = IO.delay(println(line))
  }

  implicit val fileSystemIO: FileSystem[IO] = new FileSystem[IO] {
    def readFile(path: Path): IO[Path] =
      IO.pure(s"this is file with all the passwords at $path")
  }

  implicit val httpClientIO: HTTPClient[IO] = new HTTPClient[IO] {
    def postData(url: URI, body: Path): IO[Unit] =
      IO.delay(println(s"POST '$url': $body"))
  }
}
