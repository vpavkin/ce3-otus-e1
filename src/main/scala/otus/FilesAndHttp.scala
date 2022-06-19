package otus

import cats.effect.{IO, IOApp}

object FilesAndHttp extends IOApp.Simple {

  def program[F[_]]: F[Unit] = ???

  def run: IO[Unit] = {
    import Interpreters._

    program[IO]
  }
}
