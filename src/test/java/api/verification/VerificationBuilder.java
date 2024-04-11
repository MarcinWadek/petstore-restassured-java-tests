package api.verification;

import api.endpoints.ApiResponse;
import lombok.Setter;
import lombok.experimental.Accessors;

    @Setter
    @Accessors(chain = true)
    public class VerificationBuilder {

        private ApiResponse apiResponse;

        public void setResponse(ApiResponse apiResponse) {
            this.apiResponse = apiResponse;
        }

        public static VerificationBuilder build(ApiResponse apiResponse) {
            return new VerificationBuilder().setApiResponse(apiResponse);
        }

        public ResponseVerification apiResponse() {
            return new ResponseVerification(apiResponse);
        }
}
