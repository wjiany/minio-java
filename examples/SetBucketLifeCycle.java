/*
 * MinIO Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2019 MinIO, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SetBucketLifeCycle {
  /** MinioClient.SetBucketLifeCycle() example. */
  public static void main(String[] args)
      throws IOException, NoSuchAlgorithmException, InvalidKeyException {
    try {
      /* Amazon S3: */
      MinioClient minioClient =
          new MinioClient("https://s3.amazonaws.com", "YOUR-ACCESSKEYID", "YOUR-SECRETACCESSKEY");
      String lifeCycle =
          "<LifecycleConfiguration><Rule><ID>expire-bucket</ID><Prefix></Prefix>"
              + "<Status>Enabled</Status><Expiration><Days>365</Days></Expiration>"
              + "</Rule></LifecycleConfiguration>";

      minioClient.setBucketLifeCycle("my-bucketName", lifeCycle);
    } catch (MinioException e) {
      System.out.println("Error occurred: " + e);
    }
  }
}
