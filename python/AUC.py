#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Filename: AUC
# Author  : yuanzhou
# Date    : 2021/5/11
# Description:

import numpy as np
import matplotlib.pyplot as plt
data_len = 50
label = np.random.randint(0, 2, size=data_len)
score = np.random.choice(np.arange(0.1, 1, 0.01), data_len)


def PR_curve(y,pred):
    pos = np.sum(y == 1)
    neg = np.sum(y == 0)
    pred_sort = np.sort(pred)[::-1]  # 从大到小排序
    index = np.argsort(pred)[::-1]  # 从大到小排序
    y_sort = y[index]
    print(y_sort)

    Pre = []
    Rec = []
    for i, item in enumerate(pred_sort):
        if i == 0:#因为计算precision的时候分母要用到i，当i为0时会出错，所以单独列出
            Pre.append(1)
            Rec.append(0)


        else:
            Pre.append(np.sum((y_sort[:i] == 1)) /i)
            Rec.append(np.sum((y_sort[:i] == 1)) / pos)
    print(Pre)
    print(Rec)
    ## 画图
    plt.plot(Rec, Pre, 'k')
    # plt.legend(loc='lower right')

    plt.title('Receiver Operating Characteristic')
    plt.plot([(0, 0), (1, 1)], 'r--')
    plt.xlim([-0.01, 1.01])
    plt.ylim([-0.01, 01.01])
    plt.ylabel('Precision')
    plt.xlabel('Recall')
    plt.show()


def ROC_curve(y, pred):
    pos = np.sum(y == 1)
    neg = np.sum(y == 0)
    pred_sort = np.sort(pred)[::-1]  # 从大到小排序
    index = np.argsort(pred)[::-1]  # 从大到小排序
    y_sort = y[index]
    print(y_sort)
    tpr = []
    fpr = []
    thr = []
    for i, item in enumerate(pred_sort):
        tpr.append(np.sum((y_sort[:i] == 1)) / pos)
        fpr.append(np.sum((y_sort[:i] == 0)) / neg)
        thr.append(item)
    print(fpr)
    print(tpr)
    print(thr)

    # 画图
    plt.plot(fpr, tpr, 'k')
    plt.title('Receiver Operating Characteristic')
    plt.plot([(0, 0), (1, 1)], 'r--')
    plt.xlim([-0.01, 1.01])
    plt.ylim([-0.01, 01.01])
    plt.ylabel('True Positive Rate')
    plt.xlabel('False Positive Rate')
    plt.show()
