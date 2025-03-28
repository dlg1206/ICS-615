# Bandit & Trufflehog Sandbox

> Docker sandbox for using Bandit and Trufflehog

## Quickstart

1. Build the image

```bash
docker build -t btsand .
```

> [!WARNING]
> The first build may take several minutes

2. Launch the Sandbox container

```bash
docker run --rm -it -v "<absolute path to project>:/code" -v "$(pwd)/out:/out" btsand
```

This will run both bandit and trufflehog of the mounted directory and save the output the out directory