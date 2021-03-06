/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.play.bootstrap.controller

import play.api.mvc._
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.HeaderCarrierConverter

@deprecated("Use BackendController instead", "0.4.0")
abstract class BaseController(cc: ControllerComponents) extends BackendController(cc)

abstract class BackendController(cc: ControllerComponents)
    extends AbstractController(cc)
    with Utf8MimeTypes
    with WithJsonBody
    with MdcExecutionContextProvider
    with BackendHeaderCarrierProvider

trait BackendHeaderCarrierProvider {
  implicit protected def hc(implicit request: RequestHeader): HeaderCarrier =
    HeaderCarrierConverter.fromHeadersAndSessionAndRequest(request.headers, request = Some(request))
}
