package hr.fer.oop.week9.stat;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 * File visitor which takes count,size and maps of extensions and first letters.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class MyFileVisitor implements FileVisitor<Path> {

	public Map<String, Extension> extensionMap;
	public Map<String, FirstLetter> firstLetterMap;
	public int counter;
	public long sizeAll;

	public MyFileVisitor() {
		this.extensionMap = new HashMap<String, Extension>();
		this.firstLetterMap = new HashMap<String, FirstLetter>();
		this.counter = 0;
		this.sizeAll = 0;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {

		this.counter++;
		this.sizeAll += file.toFile().length();

		// Za ekstenzije

		String extension = "";

		int i = file.toFile().getName().lastIndexOf('.');
		if (i > 0) {
			extension = file.toFile().getName().substring(i + 1).toLowerCase();
		}

		if (extensionMap.containsKey(extension)) {
			extensionMap.get(extension).count++;
			extensionMap.get(extension).size += file.toFile().length();
		} else {
			extensionMap.put(extension, new Extension(extension, file.toFile()
					.length()));
		}

		String firstLetter = file.toFile().getName().substring(0, 1);

		if (firstLetterMap.containsKey(firstLetter)) {
			firstLetterMap.get(firstLetter).count++;
			firstLetterMap.get(firstLetter).size += file.toFile().length();
		} else {
			firstLetterMap.put(firstLetter, new FirstLetter(firstLetter, file
					.toFile().length()));
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

}
