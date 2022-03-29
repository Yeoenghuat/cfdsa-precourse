FROM python:alpine
ARG PACKAGE="curl"

RUN apk update \
    && apk upgrade \
    && apk add ${PACKAGE}

ADD . .

RUN pip install -r requirements.txt

HEALTHCHECK --interval=30s --timeout=5s --start-period=5s --retries=3 \
  CMD  curl -s -f http://localhost:${PORT}/healthz > /dev/null || exit 1

ENTRYPOINT [ "sh", "./run.sh" ]