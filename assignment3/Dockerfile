# Build trufflehog
FROM golang:1.24.1-alpine3.21 AS trufflehog_build
ENV TRUFFLEHOG_GITHUB="https://github.com/trufflesecurity/trufflehog.git"
ARG TRUFFLEHOG_VERSION="v3.88.20"
RUN apk add --no-cache git
WORKDIR /trufflehog
RUN git clone $TRUFFLEHOG_GITHUB . && git checkout $TRUFFLEHOG_VERSION
RUN go install

# create toolbox
FROM python:3.9.21-alpine3.21 AS toolbox
ENV PATH=/home/hobbes/.local/bin:$PATH
RUN apk add --no-cache git
# create user
RUN adduser -D hobbes
WORKDIR /home/hobbes
RUN chown -R hobbes:hobbes /home/hobbes
# copy trufflehog
COPY --from=trufflehog_build /go/bin/trufflehog /usr/local/bin/
# install bandit
USER hobbes
RUN pip install --user --no-cache-dir bandit

ENTRYPOINT ["ash"]
