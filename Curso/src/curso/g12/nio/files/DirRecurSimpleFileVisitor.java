package curso.g12.nio.files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DirRecurSimpleFileVisitor {

	public static void main(String[] args) throws IOException {
		Path startingDir = Paths.get(".");
		Files.walkFileTree(startingDir, new FindJavaVisitor());
	}
}

class FindJavaVisitor extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

		if (file.toString().endsWith(".java")) {
			System.out.println("-"+file.getFileName());
		}
		return FileVisitResult.CONTINUE;
	}
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		System.out.println(dir.getFileName());
		return FileVisitResult.CONTINUE;
	}

}
