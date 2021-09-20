FROM jboss/base:latest

#From https://gist.github.com/MichalZalecki/4a87880bbe7a3a5428b5aebebaa5cd97
ARG USER_NAME="main"
ARG USER_PASSWORD="main"

ENV USER_NAME $USER_NAME
ENV USER_PASSWORD $USER_PASSWORD
ENV CONTAINER_IMAGE_VER=v1.0.0

RUN echo $USER_NAME
RUN echo $USER_PASSWORD
RUN echo $CONTAINER_IMAGE_VER

# install the tooks i wish to use
USER root

RUN yum install -y epel-release \
    && yum install -y java-latest-openjdk \
    curl \
    git-core \
    less \
    passwd \
    sudo \
    vim \
    wget \
    zsh \
    # add a user (--disabled-password: the user won't be able to use the account until the password is set)
    && adduser -p ${USER_PASSWORD} --shell /bin/zsh --home /home/$USER_NAME -c "User" ${USER_NAME} \
    # update the password
    && echo ${USER_NAME}:${USER_PASSWORD} | chpasswd \
    && usermod -aG wheel ${USER_NAME}
  

# install WildFly
RUN curl -O https://download.jboss.org/wildfly/24.0.1.Final/wildfly-24.0.1.Final.tar.gz \
 && tar zxvf wildfly-24.0.1.Final.tar.gz \ 
 && mv wildfly-24.0.1.Final /opt/jboss/wildfly \
 && chown -R jboss.jboss /opt/jboss/wildfly \
 && rm wildfly-24.0.1.Final.tar.gz


RUN /opt/jboss/wildfly/bin/add-user.sh admin admin#7rules --silent
RUN /opt/jboss/wildfly/bin/add-user.sh -a -u ejbclient ejb01acceS --silent -g 'guest'
ADD --chmod=0755 wildfly-init-config.sh /opt/jboss/wildfly/bin
ADD --chmod=0755 configure.cli /opt/jboss/wildfly/bin

# # the user we're applying this too (otherwise it most likely install for root)
# USER $USER_NAME
# # terminal colors with xterm
# ENV TERM xterm
# # set the zsh theme
# ENV ZSH_THEME robbyrussell

# # run the installation script  
# #  RUN wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | zsh || true
# RUN sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"

# # CMD [ "zsh" ]
# # CMD [ "tail", "-f", "/dev/null"]

USER jboss


CMD [ "/opt/jboss/wildfly/bin/wildfly-init-config.sh" ]  
