package randomduLieu.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.com.Data;

public class random {

	public static void main(String[] args) {
		// đọc file
		BufferedReader br = null;
		ArrayList<Data> ListData = new ArrayList<Data>();
		try {
			br = new BufferedReader(new FileReader("iris.dat"));
			String textInALine;
			while ((textInALine = br.readLine()) != null) {
				String[] split1 = textInALine.trim().split("\\s\\s\\s");
				String[] split2 = split1[3].split("\\s\\s");
				Data data = new Data(Float.parseFloat(split1[0]), Float.parseFloat(split1[1]),
						Float.parseFloat(split1[2]), Float.parseFloat(split2[0]), Integer.parseInt(split2[1]),
						Integer.parseInt(split2[2]), Integer.parseInt(split2[3]));
				ListData.add(data);
			}
			System.out.println("Size List data = " + ListData.size());
			br.close();
			
			// random
			// b1: lưu data sau khi random
			// b2: lưu 80% data sau khi random vào file random80
			// b3: lưu 20% data sau khi random vào file random20 và xóa hết class lable

			// === b1 ====
			Random rd = new Random();
			FileWriter writerData = new FileWriter("fileRandom.dat");
			BufferedWriter bufferData = new BufferedWriter(writerData);
			List<Data> dataAfterRandom = new ArrayList<Data>();
			int sizeDataRandom = ListData.size();
			for (int i = 0; i < sizeDataRandom; i++) {
				int numberRandom = rd.nextInt(ListData.size());
				dataAfterRandom.add(ListData.get(numberRandom));
				bufferData.write(dataAfterRandom.get(i).getF1() + " " + dataAfterRandom.get(i).getF2() + " "
						+ dataAfterRandom.get(i).getF3() + " " + dataAfterRandom.get(i).getF4() + " "
						+ dataAfterRandom.get(i).getC1() + " " + dataAfterRandom.get(i).getC2() + " "
						+ dataAfterRandom.get(i).getC3() + "\n");
				ListData.remove(numberRandom);
			}
			bufferData.close();
			
			// === b2 ====
			FileWriter writer = new FileWriter("random80.dat");
			BufferedWriter buffer = new BufferedWriter(writer);
			int numberTrain = (dataAfterRandom.size() * 80) / 100;
			List<Data> dataTrainRandomOf80 = new ArrayList<Data>();
			for (int i = 0; i < numberTrain; i++) {
				dataTrainRandomOf80.add(dataAfterRandom.get(i));
				buffer.write(dataTrainRandomOf80.get(i).getF1() + " " + dataTrainRandomOf80.get(i).getF2() + " "
						+ dataTrainRandomOf80.get(i).getF3() + " " + dataTrainRandomOf80.get(i).getF4() + " "
						+ dataTrainRandomOf80.get(i).getC1() + " " + dataTrainRandomOf80.get(i).getC2() + " "
						+ dataTrainRandomOf80.get(i).getC3() + "\n");
			}
			System.out.println("DataTraining size = " + dataTrainRandomOf80.size());
			buffer.close();

			// === b3 ====
			FileWriter writers = new FileWriter("random20.dat");
			BufferedWriter buffers = new BufferedWriter(writers);
			int numberTest = (dataAfterRandom.size() * 20) / 100;
			List<Data> dataTestRandomOf20 = new ArrayList<Data>();
			for (int i = 0; i < numberTest; i++) {
				dataTestRandomOf20.add(dataAfterRandom.get(i));
				buffers.write(dataTestRandomOf20.get(i).getF1() + " " + dataTestRandomOf20.get(i).getF2() + " "
						+ dataTestRandomOf20.get(i).getF3() + " " + dataTestRandomOf20.get(i).getF4() + " " + "\n");
			}
			System.out.println("DataTesting size = " + dataTestRandomOf20.size());
			buffers.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
