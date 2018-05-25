package com.icarusrises.caseyellowgateway.services.analysis;

import com.icarusrises.caseyellowgateway.domain.analysis.model.*;

public interface AnalysisService {
    OcrResponse ocrRequest(GoogleVisionRequest googleVisionRequest);
    ImageClassificationResult classifyImage(String identifier, VisionRequest visionRequest);
    DescriptionMatch isDescriptionExist(String user, String identifier, boolean startTest, GoogleVisionRequest visionRequest);
    HTMLParserResult retrieveResultFromHtml(String identifier, HTMLParserRequest htmlParserRequest);
    void startButtonSuccessfullyFound(String user, String identifier, int x, int y, VisionRequest visionRequest);
    void startButtonFailed(String user, String identifier, int x, int y, VisionRequest visionRequest);
}
