package src.me.micael;

import src.me.micael.controllers.MusicDataset;
import src.me.micael.entities.MusicLinkedList;
import src.me.micael.entities.MusicVector;
import src.me.micael.interfaces.MusicCollection;
import src.me.micael.interfaces.Sorter;
import src.me.micael.sorters.SortByArtistWithSelectionSort;
import src.me.micael.sorters.SortByTrackWithBubbleSort;
import src.me.micael.tests.MusicCollectionTest;

public class Main {

	public static void main(String[] args) {

		/*
		 * 
		 * Testes utilizando Lista Encadeada
		 * 
		 */

		MusicCollection musicColectionWithList = new MusicLinkedList();

		MusicDataset.readDefaultDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/input/dataset.csv",
				musicColectionWithList);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/output/datasetFormatadoListaEncadeada.csv",
				musicColectionWithList);

		/*
		 * 
		 * Testes dos métodos
		 * 
		 * 
		 */

		System.out.println("Teste adicionar música: " + MusicCollectionTest.testAddMusic(musicColectionWithList));

		System.out.println("Teste trocar música: " + MusicCollectionTest.testChangeMusic(musicColectionWithList));
		System.out.println("Teste trocar posição de músicas: "
				+ MusicCollectionTest.testChangeMusicPositions(musicColectionWithList));

		System.out.println("Teste deletar música: " + MusicCollectionTest.testDeleteMusic(musicColectionWithList));
		System.out.println(
				"Teste deletar a mesma música: " + MusicCollectionTest.testDeleteMusic(musicColectionWithList));

		/*
		 * 
		 * Ordenar via BubbleSort
		 * 
		 * 
		 */

		Sorter sorterBubbleLinkedList = new SortByTrackWithBubbleSort();
		sorterBubbleLinkedList.sort(musicColectionWithList);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/output/ordenado/datasetOrdenadoListaEncadeadaBubble.csv",
				musicColectionWithList);

		/*
		 * 
		 * Ordenar via SelectionSort
		 * 
		 * 
		 */
		Sorter sorterSelectionSortLinkedList = new SortByArtistWithSelectionSort();
		sorterSelectionSortLinkedList.sort(musicColectionWithList);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/output/ordenado/datasetOrdenadoListaEncadeadaSelection.csv",
				musicColectionWithList);

		/*
		 * 
		 * Testes utilizando Vetor
		 * 
		 * 
		 */
		MusicCollection musicCollectionWithVector = new MusicVector(20020);

		MusicDataset.readDefaultDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/input/dataset.csv",
				musicCollectionWithVector);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/output/datasetFormatadoVetor.csv",
				musicCollectionWithVector);

		/*
		 * 
		 * Testes dos métodos
		 * 
		 * 
		 */
		System.out.println("-------------------");
		System.out.println("Teste adicionar música: " + MusicCollectionTest.testAddMusic(musicCollectionWithVector));

		System.out.println("Teste trocar música: " + MusicCollectionTest.testChangeMusic(musicCollectionWithVector));
		System.out.println("Teste trocar posição de músicas: "
				+ MusicCollectionTest.testChangeMusicPositions(musicCollectionWithVector));

		System.out.println("Teste deletar música: " + MusicCollectionTest.testDeleteMusic(musicCollectionWithVector));
		System.out.println(
				"Teste deletar a mesma música: " + MusicCollectionTest.testDeleteMusic(musicCollectionWithVector));

		/*
		 * 
		 * Ordenar via BubbleSort
		 * 
		 * 
		 */
		Sorter sorterBubbleVector = new SortByTrackWithBubbleSort();
		sorterBubbleVector.sort(musicCollectionWithVector);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/output/ordenado/datasetOrdenadoVetorBubble.csv",
				musicCollectionWithVector);

		/*
		 * 
		 * Ordenar via SelectionSort
		 * 
		 * 
		 */

		Sorter sorterSelectionSortVector = new SortByArtistWithSelectionSort();
		sorterSelectionSortVector.sort(musicCollectionWithVector);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/src/io/output/ordenado/datasetOrdenadoVetorSelection.csv",
				musicCollectionWithVector);

	}

}