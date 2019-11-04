package tf_idf;

public class TFFactory {

	public TFTerm getTFCalculator(String tfType) {
		if (tfType == "documentNormalization") {
			return new TFTermDocumentNormalized();
		}
		return null;
	}
}
