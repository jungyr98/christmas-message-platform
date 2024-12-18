import "./index.css";
import { Input, Button, Form, message } from "antd";
import { useForm } from "antd/es/form/Form";
import { useRef, useEffect } from "react";
import { SERVER_URL } from "../../utils/global";

const Send = () => {
  const scriptElement = useRef<HTMLDivElement | null>(null);
  const [form] = useForm();
  const [messageApi, contextHolder] = message.useMessage();

  // 메시지 전송하기
  const fn_send = async (values: any) => {
    if (values?.message === undefined || values?.message === "") {
      messageApi.open({
        type: "warning",
        content: "내용을 입력해주세요.",
        className: "message-pop",
      });
      return false;
    }

    await fetch(`${SERVER_URL}/message/api/v1/send`, {
      method: "POST",
      body: values?.message,
    })
      .then((res) => res.json())
      .then((res) => {
        console.log("success");
      })
      .catch((e) => {
        console.log(e);
      });

    messageApi.open({
      type: "success",
      content: "익명의 메시지가 전송되었어요.",
      className: "message-pop",
    });
    form.setFieldValue("message", "");
  };

  // script 태그를 동적으로 추가
  useEffect(() => {
    // 확대 기능 방지
    const meta = document.createElement("meta");
    meta.setAttribute("name", "viewport");
    meta.setAttribute(
      "content",
      "initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width"
    );
    scriptElement?.current?.appendChild(meta);

    // 카카오 에드핏 script
    const script_adfit = document.createElement("script");
    script_adfit.setAttribute("src", "js/ba.min.js");
    script_adfit.setAttribute("charset", "utf-8");
    script_adfit.setAttribute("async", "true");
    scriptElement?.current?.appendChild(script_adfit);

    // css 효과
    const script_snow = document.createElement("script");
    script_snow.setAttribute("src", "js/snow.js");
    scriptElement?.current?.appendChild(script_snow);
  }, []);

  return (
    <div className="browser-box">
      {contextHolder}
      {/* kakao adfit */}
      <div ref={scriptElement}>
        <ins
          className="kakao_ad_area"
          style={{ display: "none" }}
          data-ad-unit="DAN-ekjnFU9hrcYvw6jv"
          data-ad-width="320"
          data-ad-height="100"
        ></ins>
      </div>
      <div className="main-box">
        <div className="message-box">
          <img src="imgFile/snowmanPixel.png" className="snowmanPixel" />
          <div className="message-box-content">
            <span className="message-box-span">
              유라님에게 크리스마스 메시지를 남겨보세요.
            </span>
            <Form form={form} onFinish={fn_send}>
              <Form.Item name={"message"} style={{ margin: "0" }}>
                <Input.TextArea
                  style={{ borderStyle: "none", width: "100%" }}
                  className="message-box-span"
                  maxLength={30}
                ></Input.TextArea>
              </Form.Item>
              <div className="message-box-btn-div">
                <Button
                  type="primary"
                  htmlType="submit"
                  size="small"
                  className="message-box-span"
                >
                  전송
                </Button>
              </div>
            </Form>
          </div>
        </div>
      </div>
      {/* kakao adfit */}
      <div ref={scriptElement}>
        <ins
          className="kakao_ad_area"
          style={{ display: "none" }}
          data-ad-unit="DAN-U10lNgWHkUImbG8u"
          data-ad-width="320"
          data-ad-height="100"
        ></ins>
      </div>
    </div>
  );
};

export default Send;
