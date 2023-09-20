package src.me.micael;

import src.me.micael.controllers.MusicDataset;
import src.me.micael.entities.MusicLinkedList;
import src.me.micael.entities.MusicVector;
import src.me.micael.interfaces.MusicCollection;

public class Main {

	public static void main(String[] args) {

		/*
		 * 
		 * Testes utilizando Lista Encadeada
		 * 
		 */

		MusicCollection musicColectionWithList = new MusicLinkedList();

		MusicDataset.readDefaultDataset("C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/io/input/dataset.csv",
				musicColectionWithList);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/io/output/datasetNovoComListaEncadeada.csv",
				musicColectionWithList);

		/*
		 * 
		 * Testes utilizando Vetor
		 * 
		 */

		MusicCollection musicColectionWithVector = new MusicVector(20020);

		MusicDataset.readDefaultDataset("C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/io/input/dataset.csv",
				musicColectionWithVector);

		MusicDataset.writeDataset(
				"C:/Users/Micael Gomes/Desktop/Faculdade/DatasetSpotify/io/output/datasetNovoComVetor.csv",
				musicColectionWithVector);

	}

}