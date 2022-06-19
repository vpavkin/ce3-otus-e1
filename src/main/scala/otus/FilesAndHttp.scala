package otus

import cats.effect.{IO, IOApp}

object FilesAndHttp extends IOApp.Simple {

  def program[F[_]: Console: FileSystem: HTTPClient]: F[Unit] = ???

  def run: IO[Unit] = {
    import Interpreters._

    program[IO]
  }
}
