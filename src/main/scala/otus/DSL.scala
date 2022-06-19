package otus

trait Console[F[_]] {
  def printLine(line: String): F[Unit]
  def readLine: F[String]
}
object Console {
  def apply[F[_]: Console]: Console[F] = implicitly
}

trait FileSystem[F[_]] {
  def readFile(path: Path): F[String]
}
object FileSystem {
  def apply[F[_]: FileSystem]: FileSystem[F] = implicitly
}

trait HTTPClient[F[_]] {
  def postData(url: URI, body: String): F[Unit]
}
object HTTPClient {
  def apply[F[_]: HTTPClient]: HTTPClient[F] = implicitly
}
